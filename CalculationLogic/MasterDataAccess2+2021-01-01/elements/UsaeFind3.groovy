
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

// ==================================================
// use lookupTable.id with find
// ==================================================

def table = api.findLookupTable("PriceListApprovalLevels")

api.trace("Table", table)

def row = api.find("MLTV", 0, 1, null,
        Filter.equal("lookupTable.id", table?.id),
        Filter.equal("name", "Extra")
)?.find()

api.trace("Step 1 Row from api.find(MLTV)", row)

def table1 = api.findLookupTable("ExchangeRate")

api.trace("Table", table1)

def row1 = api.find("MLTV3", 0, 1, null,
        Filter.equal("lookupTable.id", table1?.id)
)?.find()

api.trace("Step 2 Row from api.find(MLTV3)", row1)




