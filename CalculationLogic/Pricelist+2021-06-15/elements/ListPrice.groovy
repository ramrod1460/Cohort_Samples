

if(null in [out.BasePrice, out.MarginAdjAbs, out.AttributeAdjAbs]) {
    api.addWarning("List Price cannot be calculated: missing parameter(s).")
    return null
}

def listPrice = out.BasePrice + out.MarginAdjAbs + out.AttributeAdjAbs
api.trace("Base Price ", out.BasePrice)
api.trace("MarginAdjAbs ", out.MarginAdjAbs)
api.trace("AttributeAdjAbs ", out.AttributeAdjAbs)
def roundedListPrice = libs.SharedLib.RoundingUtils.round(listPrice, 2)

api.trace("List Price",  listPrice)
api.trace("Rounded List Price", roundedListPrice)

if ( listPrice > 30 ) {
    api.addWarning("High Price")
}
return roundedListPrice*2


