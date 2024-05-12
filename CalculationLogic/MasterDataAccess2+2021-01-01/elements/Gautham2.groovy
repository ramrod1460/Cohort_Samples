def date = api.targetDate().format("yyyy-MM-dd")

api.trace("date", date)

def filters = [
        Filter.lessOrEqual("lastUpdateDate", date),
        Filter.equal("attribute2", null)
]

def prodCostRecords = api.productExtension("ProductCost", *filters)

return prodCostRecords
