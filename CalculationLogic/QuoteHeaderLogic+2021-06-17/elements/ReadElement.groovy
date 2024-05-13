
/**
if (quoteProcessor.isPostPhase()) {

    getFolderDealScore("ROOT")

}

def getFolderDealScore(folderId) {
    def qp = quoteProcessor
    def h = qp.getHelper()
    def folderScore = 0
    def numItems = 0
    def folder = null

    if(folderId == "ROOT")
        folder = h.getRoot()
    else
        folder = h.findByLineId(folderId)


    if(folder == null) return 0

    for(line in folder.getChildren()) {
        def lineScore = 0

        if(line.isFolder()) {
            api.trace("Line is folder")
            lineScore = getFolderDealScore(line.getLineId())
        } else {
            api.trace("Line is NOT folder")
            def outputMap = line.getOutputByName("DealScore")
            lineScore = outputMap?.result
        }
        numItems++
        folderScore = folderScore + (lineScore == null ? 0 : lineScore)
    }

    if(numItems == 0) return 0
    else {
        folderScore = folderScore/numItems
        qp.addOrUpdateOutput(folderId, ["resultName": "DealScore", "resultLabel": "Deal Score", "result" : folderScore])
        return folderScore
    }
}
 */

if (quoteProcessor.isPrePhase()) {
    def expiryDate = quoteProcessor.getQuoteView().expiryDate
    api.logInfo("ExpiryDate in Header", expiryDate)
    api.trace("ExpiryDate in Header", expiryDate)
    for (lineItemMap in quoteProcessor.getQuoteView().lineItems) {
        if (lineItemMap.folder) continue // skip folders
        quoteProcessor.addOrUpdateInput(lineItemMap.lineId,
                ["name"    : "expiryDate",
                 "label"   : "Expiry Date",
                 "type"    : InputType.HIDDEN,
                 "required": false,
                 "readOnly": true,
                 "value"   : expiryDate
                ]
        )
    }
}