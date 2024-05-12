// =================================================================
// NOTE : api.stream CANNOT be used in inputGenerationExecution mode
// =================================================================
List<String> fields = ["sku", "attribute1", "attribute2"]

def filters = [
        Filter.equal("ProductGroup","Pork")
]

def iterator = api.stream("P", "sku", fields, *filters)

while (iterator?.hasNext()) {
    def comp = iterator.next()
    if (comp.sku != null && comp.attribute1 != null) {
        def row = [
                "sku"         : comp.sku,
                "ProductGroup": comp.attribute1,
                "BusinessUnit": comp.attribute2
        ]
        api.trace("Stream Row: ", row)
    }
}


/**
for ( def comp in iterator ) {

    if (comp.sku != null && comp.attribute1 != null) {
        def row = [
                "sku"         : comp.sku,
                "ProductGroup": comp.attribute1,
                "BusinessUnit": comp.attribute2
        ]
        api.trace("Stream Row: ", row)
    }
}
*/

iterator?.close()