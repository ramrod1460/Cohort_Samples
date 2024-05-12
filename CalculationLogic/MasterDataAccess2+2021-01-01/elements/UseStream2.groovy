// =================================================================
// NOTE : api.stream CANNOT be used in inputGenerationExecution mode
// =================================================================
List<String> fields = ["sku", "pricelistId", "resultPrice"]

def id = 22281
def filters = [
        Filter.notEqual("pricelistId", null)
]

def iterator = api.stream("PLI", "pricelistId", fields, *filters)

while (iterator?.hasNext()) {
    def comp = iterator.next()

    api.trace("Stream Row: ", comp)
}


iterator?.close()