api.logInfo("Rod Valid Cost")
return cost = (api.productExtension("ProductCost")?:null)?.first()?.attribute1

// Ternary Operator