// See https://pricefx.atlassian.net/wiki/spaces/KB/pages/649035780/How+to+Query+a+Data+Source+Directly

def ctx = api.getDatamartContext()

def dm = ctx.getDataSource("Currencies")
def dsQuery = ctx.newQuery(dm, false)

def filters = [
        Filter.equal("CcyFrom","USD")
]

dsQuery.select("CcyFrom","From")
dsQuery.select("CcyTo","To")
dsQuery.select("CcyExchangeRate","ExchangeRate")

dsQuery.where(*filters)

def result = ctx.executeQuery(dsQuery)

/**
result?.getData()?.each {
    api.trace("I see : "+it)
}


def resultMatrix = result?.getData()?.toResultMatrix()
//api.trace("I see Matrix : "+resultMatrix)

// ================ as a Stream

resultIterator = ctx.streamQuery(dsQuery)

def r=0
while(resultIterator.next()){
    def row =resultIterator.get()  // current row as map
    //api.trace("streamQuery", "row $r", row)
    api.trace("From : "+row.From+" To : "+row.To+" ExcahngeRate : "+row.ExchangeRate)
    r++
}
resultIterator.close()
 */

