/**
 * use Lookup to find record(s) where key1 == America and key2 == Sausage, however,
 * if key2 == Sausage cannot be found, just return all cases where key1 == America
 */
List filters2 = [
        Filter.equal("key1", "America"),
        Filter.equal("key2", "Sausage"),
]

def threshold2 = api.findLookupTableValues("SalesDiscountThreshold", *filters2)

if ( threshold2.isEmpty()) {
    filters2 = [
            Filter.equal("key1", "America"),
    ]
    threshold2 = api.findLookupTableValues("SalesDiscountThreshold", *filters2)
}
api.trace("Yellow Alert 2", threshold2)