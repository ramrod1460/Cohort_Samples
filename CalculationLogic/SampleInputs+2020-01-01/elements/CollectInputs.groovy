if (api.isInputGenerationExecution()) {

    // ==================================================================
    // Note: When testing be sure to go to Inputs tab, select Product context and click
    //       Generate to cause the inputs to be displayed for selection
    // ==================================================================

    // Prepare desired Customer(s) list for input/display
    def filters = [
            Filter.equal("Country", "USA"),
            Filter.isNotEmpty("name"),
            Filter.equal("attribute4", "B")
    ]

    def fields = [
            "customerId",
            "name",
            "attribute6", // Country
            "attribute4"   // Customer Class
    ]

    // Collect filtered customer Map - the Map is for input Labels
    // =================================================================
    // NOTE : api.stream CANNOT be used in inputGenerationExecution mode
    // =================================================================
    def customerMap = api.find("C", 0, api.getMaxFindResultsLimit(), "customerId", fields, *filters)?.collectEntries() {
        [(it.customerId): it.name]
    }

    // Prep a customer List for input selection
    def customerList = []
    customerMap.each { customerField ->
        customerList.add(customerField?.getKey())
    }

    api.trace("Map is ", customerMap)
    api.trace("List is ", customerList)

    api.inputBuilderFactory()
            .createOptionEntry("Customer")
            .setLabel("Customer List")
            .setOptions(customerList)
            .setLabels(customerMap)
            .getInput()

    // Inputs based on data in a PP table
    // Prepare Regions list for input/display
    def regions = api.findLookupTableValues("Region")?.collect { it.name }?.sort()
    api.inputBuilderFactory()
            .createOptionEntry("Region")
            .setLabel("Region")
            .setRequired(true)
            .setOptions(regions)
            .getInput()
}



