/**
 * use Lookup to find record(s) where key1 == America and key2 == Sausage, however,
 * if key2 == Sausage cannot be found, just return all cases where key1 == America
 */
def desiredResultList = []
def everythingElse = []

//key2 = "Sausage"
key2 = "Snails"

List filters2 = [
        Filter.equal("key1", "America"),
]

api.findLookupTableValues("SalesDiscountThreshold", *filters2).findAll { record ->
    if ( record.key2 == key2 ) {
        desiredResultList.add(record)
    } else {
        everythingElse.add(record)
    }
}

if ( desiredResultList.isEmpty() ) {
    api.trace("$key2 were NOT found ...result is", everythingElse)
} else {
    api.trace("$key2 WERE found ...result is", desiredResultList)
}

