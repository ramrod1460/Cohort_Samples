if (quoteProcessor.isPrePhase()) {
    api.retainGlobal = true
    api.global["CustomerName"] = quoteProcessor.quoteView.customerName
    api.global["UniqueName"] = quoteProcessor.quoteView.uniqueName
    api.global["TargetDate"] = quoteProcessor.quoteView.targetDate
}