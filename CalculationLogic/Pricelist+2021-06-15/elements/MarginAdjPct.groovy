/*
def productGroup = api.product("ProductGroup")
def marginAdjPct = api.vLookup("MarginAdj", productGroup)

if(marginAdjPct == null) {
    api.addWarning("Unable to look up Margin Adjustment due to invalid Product Group")
}
*/

api.trace("BasePrice is : ",out.BasePrice)
def marginAdjPct = PricelistLib.marginAdj()

PricelistLib.onePlusOne(3)

if(marginAdjPct == null) {
    api.addWarning("Unable to look up Margin Adjustment with the Product Group")
}

return marginAdjPct