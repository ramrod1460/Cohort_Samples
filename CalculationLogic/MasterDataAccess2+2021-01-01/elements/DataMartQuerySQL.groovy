def ctx = api.getDatamartContext()
def dm = ctx.getDatamart("Transaction")
def filters = [
        Filter.equal("ProductId","MB-0001"),
        //Filter.equal("InvoiceDateMonth","2022-M11"),
        Filter.equal("InvoiceDateYear","2022"),
]
def query = ctx.newQuery(dm, false)
        .select("Quantity")
        .select("ProductId")

query.where(*filters)

// =========================================

 def sql = '''
 SELECT 
 SUM(T1.Quantity) AS TQ
 FROM T1
 '''

 def dmQueryResult = ctx.executeSqlQuery(sql, query)

 api.trace("Result", dmQueryResult)
 api.trace("Result Value", dmQueryResult?.value)

// ========================================================