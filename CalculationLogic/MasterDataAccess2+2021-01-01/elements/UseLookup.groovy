def row = []
List<String> fields = ["sku", "attribute1", "attribute2"]

//def iterator = api.stream("P", "sku", fields, *filters)
def iterator = api.stream("P", "sku", fields)
//def iterator = api.stream("P", "sku", fields)

while (iterator?.hasNext()) {
    def comp = iterator.next()
    if (comp.sku != null && comp.attribute1 != null) {
        row = [
                "sku"         : comp.sku,
                "ProductGroup": comp.attribute1,
                "BusinessUnit": comp.attribute2,
                "Margin Adj" : api.vLookup("MarginAdj", comp.attribute1)
        ]
        api.trace("Row: ", row)

    }
}

iterator?.close()

// ================================

