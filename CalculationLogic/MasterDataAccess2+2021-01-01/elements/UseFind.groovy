def start = 0
def data = null
List<String> fields = ["sku", "attribute1", "attribute2"]

def filters = [
        Filter.equal("ProductGroup","Pork")
]

def rod = api.find("P", start, api.getMaxFindResultsLimit(), "sku", fields, *filters)
api.trace("Rod is:", rod)

//def rod2 = api.find("P",start, api.getMaxFindResultsLimit(),"sku",)

while (data = api.find("P", start, api.getMaxFindResultsLimit(), "sku", fields, *filters)) {
    start += data.size()
    for (row in data) {
        def out = [
                "sku"         : row.sku,
                "ProductGroup": row.attribute1,
                "BusinessUnit": row.attribute2,
        ]
        api.trace("Find Row: ", out)
    }
    api.trace("Data Size: ", data.size())
}





