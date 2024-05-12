List<String> fields = ["attribute1"]

def filters = [Filter.equal("sku",api.product("sku"))]

def avgCost = api.find("PX3",0,1,"attribute1",fields,*filters)
        .attribute1.getAt(0)

def avgCost2 = api.find("PX3",0,1,"attribute1",fields,Filter.equal("sku",api.product("sku")))
        .attribute1.getAt(0)

return avgCost