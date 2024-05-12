// =================================================
// Debug Code Start
//
// The DEBUG block of code is here to breakdown the more complicated
// code which appears below the Debug Code End comment in this logic.
// The idea is to allow the student to run the code and review the results
// of each step onf the programmed solution.
//
// The overall goal of the code is to take the Product in Context and find the
// Competitive pricing available for ONLINE only products. We must NOT select any
// competitor who has an advertised Price that is in the Future ( beyone todays date or document
// Target date.
//
// We should return the LOWEST priced product with a competition date ( infoDate )
// that is closest to our Target date without being in the future.
//
// Example. if we have 3 matching entries for our product for each of 3 dates
// ( 5/14, 5/15, 6/16 ) we would return the LOWEST priced competitor value that
// is ONLINE and NOT in the future.
//
// Assume a Document Target Date of May 9th
// Assume a Todays Date is May 30th
//
// Sample Competition table entries
//
//   infoDate   Price
// 1. 5/14 -    $2.35
// 2. 5/14 -    $2.45
// 3. 5/14 -    $3.15
// 4. 5/15 -    $2.35
// 5. 5/15 -    $2.45
// 6. 5/15 -    $1.75
// 7. 6/16 -    $2.05
// 8. 6/16 -    $1.45
// 9. 6/16 -    $4.15
//
// Correct entry to select would be # 6
// =================================================
/**
 * Spaceship operator Example - returns 0 ( Equal ) , negative 1 a < b, one ( 1 ) a > b
 *
 * groovy> def d = new Date()
 * groovy> println d <=> d
 * groovy> println 3 <=> 4
 * groovy> println “doberman” <=> “dachshund”
 * groovy> println d <=> new Date()

 0
 -1
 1
 -1
 */

// Find competition which is ONLINE and infoDate is less than Target date
def x = api.productCompetition(
        Filter.equal("competitionType", "Online"),
        Filter.lessThan("infoDate", api.targetDate()?.format("yyyy-MM-dd"))
)

api.trace("Competition no sort : ",x)

// Sort result set on Date with most recent Date on top
api.trace("Competition sort on 1 col : ",
        x.sort { a, b ->
            b.infoDate <=> a.infoDate }
)

api.trace("Competition sort on 2 col : ",
        x.sort { a, b ->
            b.infoDate <=> a.infoDate ?:
                    a.price <=> b.price}
)

// Now Sort result set on Price within Date with lowest price for the given
// Date on Top
api.trace("Competition sort  on 2 col & find: ",
        x.sort { a, b ->
            b.infoDate <=> a.infoDate ?:
                    a.price <=> b.price }?.find()
)

api.trace("X & find: ",  x?.find() )

// =================================================
// Debug Code End
// =================================================

// Following is how we would actually write the code for production
compPrice =  api.productCompetition(
        Filter.equal("competitionType", "Online"),
        Filter.lessThan("infoDate", api.targetDate()?.format("yyyy-MM-dd"))
)?.sort { a, b ->
    b.infoDate <=> a.infoDate ?:
            a.price <=> b.price }
        ?.find()


if ( compPrice == null || compPrice == 0 ) {
    api.addWarning("No competitior price found ...using current price")
    def compMap = [:]
    compMap = ["competitor": "!! No Competitor Found !!", "label": api.product("label"), "price": api.productExtension("ProductCost")?.find()?.attribute1]
    api.trace("CompMap is ",compMap)
    return compMap
} else {
    api.trace("Competition is ",compPrice)
    return compPrice
}







