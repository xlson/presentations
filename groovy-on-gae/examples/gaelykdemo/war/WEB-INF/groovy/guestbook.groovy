import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*
 
// query the scripts stored in the datastore
def query = new Query("guestbookentry")
 
// sort results by descending order of the creation date
query.addSort("dateCreated", Query.SortDirection.DESCENDING)
 
// filters the entities so as to return only scripts by a certain author
//query.addFilter("author", Query.FilterOperator.EQUAL, params.author)
 
PreparedQuery preparedQuery = datastore.prepare(query)
 
// return only the first 10 results
def entities = preparedQuery.asList( withLimit(10) )
request.entries = entities
forward '/guestbook.gtpl'