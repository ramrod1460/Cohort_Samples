api.logInfo("Pricelist target date is : ", api.targetDate())
api.trace("Pricelist target date from api.targetDate is : ", api.targetDate())

//api.trace("Pricelist target date from api.pricelist is : ", api.pricelist("GlobalPriceList", "type"))

//api.findLookupTableValues( )

//api.trace("PlID", api.currentItem("pricelistId"))
// value in column "attribute1" in the PX table "ProductCost" for the row with sku
//def x = api.productExtension("ProductCost")?.getAt(0)?.attribute1
def avgCost = api.productExtension("ProductCost")?.find()?.attribute1

/**
def avgCost2=api.productExtension("ProductCost")?.getAt(0)?.attribute1

def avgCost3=api.productExtension("ProductCost")
def avgCostUSD=api.productExtension("ProductCost").find()?.attribute2

api.trace("Value 1", avgCost)
api.trace("Value 2", avgCost2)
api.trace("Value 3", avgCost3)
api.trace("Value 4", avgCostUSD)

// AvgCostUSD == attribute2 in PX ProductExtension
List<String> fields = ["sku", "attribute1", "AvgCostUSD"]

def filters = [
        Filter.equal("name","ProductCost")
]

def rod = api.find("PX", 0, api.getMaxFindResultsLimit(), "sku", fields, *filters)

api.trace("Rod", rod)

*/

if(avgCost == null) {
    api.addWarning("Could not find Average Cost in PX table ProductCost")
    return null
}
api.trace("Pricelist BasePrice:",avgCost)
api.logInfo("Pricelist BasePrice:",avgCost)

return avgCost