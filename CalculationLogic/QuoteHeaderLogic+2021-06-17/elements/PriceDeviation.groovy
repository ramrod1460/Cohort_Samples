import net.pricefx.common.api.FieldFormatType

if ( quoteProcessor.isPostPhase()) return

api.trace("Must be Pre Phase")

def capSize = api.inputBuilderFactory()
        .createUserEntry("PriceDeviation")
        .setLabel("Allowable Price Deviation")
        .setFormatType(FieldFormatType.PERCENT as String)
        .setRequired(false)
        .buildMap()

quoteProcessor.addOrUpdateInput(capSize)