
if (quoteProcessor.isPrePhase()) {
    return
}

api.trace("quoteProcessor.quoteView", quoteProcessor.quoteView)
api.trace("quoteProcessor.quoteView.lineItems", quoteProcessor.quoteView.lineItems)

quoteProcessor.quoteView.lineItems.findAll {
    api.trace("I see Line is ->",it) // TODO remove
}

//api.trace("quoteView", quoteProcessor.quoteView)
List<Object> lineItems = quoteProcessor.quoteView.lineItems.findAll { rod ->
    !rod.folder
}

List<String> warnings = null
BigDecimal sum = 0.0

api.trace("Line Items : ",lineItems)

for (lineItem in lineItems) {

    BigDecimal price = lineItem?.outputs?.find { lineItemOutput ->
        lineItemOutput.resultName == "TotalInvoicePrice"
    }?.result

    if (price == null) {
        sum = null
        warnings = ["Unable to calculate: value for TotalInvoicePrice is " +
                            "missing on one of the line items."]
        break
    }

    sum += price

    api.trace("Line", lineItem?.sku, price) // TODO remove
}
// ===================================
// Rod Experimental
/**
rodSum = 0
def folder =quoteProcessor.getHelper().getRoot()
for(line in folder.getChildren()) {
    def priceObject = line.getOutputByName("TotalInvoicePrice")
    api.trace("PriceObject: "+priceObject)
    def ballCapInputObject = line.getInputByName("BallCapSize")
    api.trace("BallCapInputObject: "+ballCapInputObject)

    rodSum += (priceObject != null ? priceObject?.result : 0)
}
api.trace("RodSum: "+rodSum)
 */
// ===================================

// ===================================
api.trace("Total invoice price", sum) // TODO remove

// Add output

//warnings = ["Daffy Duck"]

def output = [
        resultName   : "TotalInvoicePrice",
        resultLabel  : "Total Invoice Price",
        result       : sum,
        formatType   : "MONEY_EUR",
        resultType   : "SIMPLE",
        cssProperties: "background-color:#99FFDD",
        warnings     : warnings
]

quoteProcessor.addOrUpdateOutput(output)

api.trace("quoteView", quoteProcessor.quoteView)





