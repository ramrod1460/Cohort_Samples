//import net.pricefx.common.api.FieldFormatType

if ( api.isInputGenerationExecution() ) {
//if (api.isSyntaxCheck()) {

    // Declare input parameters, only in syntax check mode
    String fieldFormatTypePercent = FieldFormatType.PERCENT
    def beautifulStates = ["Virginia": "Blue Ridge Beautiful", "Georgia": "Peachy", "Florida":"Citrus Related"]

    api.inputBuilderFactory()
            .createIntegerUserEntry("Quantity")
            .setRequired(true)
.setFrom(1)
.setTo(200)
// setMin() Deprecated - use setFrom
//setMax() Deprecated - use setTo
            .setValue(1)
            .getInput()

    api.inputBuilderFactory()
            .createUserEntry("SalesDiscountPct")
            //.setLabel("Sales Discount (%)")
            .setFormatType("PERCENT")
            //.setFormatType(FieldFormatType.PERCENT)
            .setValue(0)
            .setFrom(0.0)  // Min value
            .setTo(0.4)  // Max value - regarding the real value kept in the input
            .setRequired(false)
            .getInput()

    api.inputBuilderFactory()
            .createRadioEntry("LineRadio")
            .setLabel("Select Radio Type")
            .setOptions(["AM","FM","Emergency"])
            .getInput()

    api.inputBuilderFactory()
            .createProductGroupEntry('productGroup')
            .getInput()

    api.inputBuilderFactory()
            .createBooleanUserEntry("Boolean")
            .setLabel("Rod Boolean")
            .setHelpText("Used to choose 'true' or 'false' value.")
            .getInput()

    api.inputBuilderFactory()
            .createOptionEntry("Smell Type")
            .setLabel("Flower Smell")
            .setRequired(true)
            .setOptions(["Flowers", "Trash"])
            .getInput()

    /**
    api.inputBuilderFactory()
            .createOptionEntry("States")
            .setLabel("Select a State")
            .setOptions(["VA1", "GA2", "FL3"])
            .setLabels(beautifulStates)
            .getInput()
    */
    // Prevent the following elements from being executed - test - 1 - 2 - 3 - 4 - 5 - 6
}

/**
 *
 // Quantity
 api.integerUserEntry("Quantity")
 def quantityParam = api.getParameter("Quantity")
 quantityParam.setLabel("Required Quantity")
 quantityParam.setRequired(true)
 // Limit values to be > 0
 quantityParam.setConfigParameter("inputType", "range")
 quantityParam.setConfigParameter("from", 1) // Min value

 // Sales Discount %
 api.userEntry("SalesDiscountPct")
 def discountParam = api.getParameter("SalesDiscountPct")
 discountParam.setLabel("Sales Discount (%)")
 discountParam.setRequired(false)
 discountParam.setValue(0) // Set initial value
 discountParam.setConfigParameter("formatType", "PERCENT")

 // Limit values to be > 0 & < 1
 discountParam.setConfigParameter("inputType", "range")
 discountParam.setConfigParameter("from", 0) // Min value
 discountParam.setConfigParameter("to", 1)   // Max value

 */
//api.inputBuilderFactory().createMultiTierEntryInputBuilder()

