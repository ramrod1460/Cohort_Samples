/**
 * See https://knowledge.pricefx.com/space/KB/99570579/Filters+for+Data+Reading
 *
 * Match on Key1 == America
 * AND
 * Key2 == "Sausage" OR, if SAUSAGE is not there, match on anything in Key2
 */
List filters2 = [
        Filter.equal("key1", "America"),
        Filter.and(
                Filter.or(
                        Filter.equal("key2", "Sausage"),
                        Filter.like("key2","Meatball")
                )
        )
]

def threshold2 = api.findLookupTableValues("SalesDiscountThreshold", *filters2)

api.trace("Yellow Alert 2", threshold2)
