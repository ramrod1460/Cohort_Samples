
if( api.isDebugMode() ) {
    // input.DeliveryType = "Express"
    return "Express"
}

if (quoteProcessor.isPostPhase()) {
    return
}

/**
def output = [
        "name"           : "DeliveryType",
        "label"          : "Delivery Type",
        "type"           : "OPTION",
        "value"          : "Express",
        "required"       : true,
        "parameterConfig": [
                "labels": [
                        "Express" : "Express Delivery",
                        "Standard": "Standard Delivery"
                ]
        ],
        "valueOptions"   : [
                "Express",
                "Standard"
        ]
]

 quoteProcessor.addOrUpdateInput(output)
*/

api.trace("DeliveryType Mode")

//.setLabels(["Express": "Express Delivery", "Standard": "Standard Delivery"])("DeliveryType")
//.setLabel("Delivery Type")
//.setRequired(true)
//.setOptions(["Express", "Standard"])
//.setLabels(["Express": "Express Delivery", "Standard": "Standard Delivery"])

def deliveryType = api.inputBuilderFactory()
        .createOptionEntry("DeliveryType")
        .setLabel("Delivery Type")
        .setRequired(true)
        .setOptions(["Express", "Standard"])
        //.setLabels(["Express": "Express Delivery", "Standard": "Standard Delivery"])("DeliveryType")
        //.setLabel("Delivery Type")
        //.setRequired(true)
        //.setOptions(["Express", "Standard"])
        //.setLabels(["Express": "Express Delivery", "Standard": "Standard Delivery"])
        .buildMap()

api.trace("quote", quoteProcessor.quoteView)

quoteProcessor.addOrUpdateInput(deliveryType)


