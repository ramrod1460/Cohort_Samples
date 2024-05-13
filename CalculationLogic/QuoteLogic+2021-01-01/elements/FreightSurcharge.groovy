
/**
if(api.isDebugMode()) {
    input.Customer = "CD-00006" // Pricefx
    input.DeliveryType = "Standard"
}
*/

def country = api.customer("Country", out.Customer)

def keys = [
        "Country": country,
        "DeliveryType": out.DeliveryType
]

api.trace("I see country / deliveryType : "+ keys)

BigDecimal surcharge = api.vLookup("FreightSurcharge", "FreightSurcharge", keys)
api.trace("Surcharge is : "+surcharge)
return surcharge