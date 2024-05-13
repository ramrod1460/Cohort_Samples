// If we are in PrePhase quit
/**
if (quoteProcessor.isPrePhase()) {
    return
}
api.trace("Postphase TIPR")
// Instantiate sum object
rodSum = 0

// Derive Quote Line Items from ROOT
def folder =quoteProcessor.getHelper().getRoot()

// Parse over lineItems and sum up TotalInvoicePrice
for(line in folder.getChildren()) {
    def priceObject = line.getOutputByName("TotalInvoicePrice")

    if (priceObject == null) {
        rodSum = null
        warnings = ["Unable to calculate: value for TotalInvoicePrice is " +
                            "missing on one of the line items."]
        break
    }

    rodSum += priceObject?.result
}

api.trace("RodSum:", rodSum)
 */