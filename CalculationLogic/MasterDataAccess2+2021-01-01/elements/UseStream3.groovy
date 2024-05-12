// =================================================================
// NOTE : api.stream CANNOT be used in inputGenerationExecution mode
// =================================================================    
def filters = [
        Filter.equal("name", "ProductCost"),
        //Filter.equal("sku", sku),
]

def fields = ["sku", "attribute1", "attribute2", "attribute3"]

def records = api.stream("PX", null, fields, *filters)
        ?.withCloseable {
            it.collect() // iterates through a collection, converting each element into a new value using the closure as the transformer
        }
api.trace("After Ccllect() ", records)

records2 = api.stream("PX", null, fields, *filters)
        ?.withCloseable {
            it.collect() // iterates through a collection, converting each element into a new value using the closure as the transformer
        }?.collectEntries { // Iterates through this Collection transforming each item using the transform closure and returning a map of the resulting transformed entries.
    [(it.sku): it.attribute1]
} ?: [:]

api.trace("After collectEntries() ", records2)
//?.collectEntries { [(it.sku): it.attribute1] } ?: [:]

records3 = api.stream("PX", null, fields, *filters)
        ?.withCloseable {
            it.collectEntries(){
                [(it.sku): it.attribute1]
            } // iterates through a collection, converting each element into a map entry
        }

api.trace("After collectEntries() shortened ", records3)