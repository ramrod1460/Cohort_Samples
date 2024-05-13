// 0 as default value
if ( input.BallCapSize != null ) {
    api.trace("Ball cap is : "+input.BallCapSize)
    api.logInfo("Ball cap is : "+input.BallCapSize)
}
api.trace("Salary is "+input.Salary)
api.logInfo("Salary is "+input.Salary)

api.trace("RodButton is "+input.RodButton)
api.logInfo("RodButton is "+input.RodButton)

api.trace("LineRadio is "+input.LineRadio)
api.logInfo("LineRadio is "+input.LineRadio)

def value = input.productGroup as Map
api.trace("productGroup is "+value)
api.logInfo("productGroup is "+value)

api.trace("currentItem SKU: "+api.currentItem("sku"))

//api.trace("currentContext: "+api.currentContext("api.currentItem("sku")"))

return input.SalesDiscountPct?:0.0

