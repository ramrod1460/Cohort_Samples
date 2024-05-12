def date = api.targetDate().format("yyyy-MM-dd")

api.trace("date", date)

def filters = [
        Filter.lessOrEqual("key3", date),
        Filter.equal("key1", "USD")
]

def exchangeRates = api.findLookupTableValues("ExchangeRate", ["key1", "key2", "key3", "attribute2"], null, *filters)

return exchangeRates
