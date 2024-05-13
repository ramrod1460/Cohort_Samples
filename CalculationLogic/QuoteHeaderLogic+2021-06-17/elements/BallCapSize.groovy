//if(api.isDebugMode() ) {
    // These inputs will be set for debug mode in the QuoteLine logic
   // return "Large"
//}

if ( quoteProcessor.isPostPhase()) return

api.trace("Must be Pre Phase")

def capSize = api.inputBuilderFactory()
    .createTextUserEntry("BallCapSize")
    .setLabel("Ball Cap Size")
    .setRequired(false)
    .buildMap()

quoteProcessor.addOrUpdateInput(capSize)

//
def salary = api.inputBuilderFactory()
        .createRadioEntry("Salary").setOptions(['Small','Medium','Large'])
        .buildMap()

quoteProcessor.addOrUpdateInput(salary)

// NOTE - inputBuilderFactory wrapped in addOrUpdateInput
quoteProcessor.addOrUpdateInput(
        'ROOT',
        api.inputBuilderFactory()
                .createButtonEntry("RodButton")
                .setLabel("Rods Button")
                .setValue("Pushed")
                .buildMap()
)



