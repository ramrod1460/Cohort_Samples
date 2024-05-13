def filters = Filter.equal("name","registrationSana")
api.find("CX",0,api.getMaxFindResultsLimit(), attribute7, ["attribute1"], *filters)
