import net.pricefx.common.api.FieldFormatType
if ( quoteProcessor.isPostPhase()) return

api.trace("Must be Pre Phase")

def capSize = api.inputBuilderFactory()
        .createUserEntry("HistoricalMonths")
        .setLabel("Historical Months to Consider")
        .setFormatType(FieldFormatType.INTEGER as String)
        .setRequired(false)
        .buildMap()

quoteProcessor.addOrUpdateInput(capSize)