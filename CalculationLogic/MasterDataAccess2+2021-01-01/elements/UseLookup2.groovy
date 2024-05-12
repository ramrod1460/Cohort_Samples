def filters1 = [
        Filter.or(
                Filter.equal("key1", "America"),
                Filter.equal("key2", "*"),
        )

]

def threshold = api.findLookupTableValues("SalesDiscountThreshold", *filters1)?.getAt(0)?.attribute1

api.trace("Yellow Alert", threshold)

/**
 * See https://knowledge.pricefx.com/space/KB/99570579/Filters+for+Data+Reading
 * Match on Key1 == America
 * AND
 * Key2 == "Sausage" OR, if SAUSAGE is not there, match on anything in Key2
 */
List filters2 = [
        Filter.equal("key1", "America"),
        Filter.and(
                Filter.or(
                        Filter.equal("key2", "Sausage"),
                        Filter.like("key2","%")
                )
        )
]

def threshold2 = api.findLookupTableValues("SalesDiscountThreshold", *filters2)
api.trace("Yellow Alert 2", threshold2)


/**
 *
 *  List filters = [
 *                  Filter.equal("priceGridId", priceGridId),
 *                  Filter.or(
 *                     Filter.in("label", labelsOrElementNames),
 *                     Filter.in("elementName", labelsOrElementNames)
 *                  )
 *               ]
 */