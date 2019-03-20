package lambda.clients;

public class GetRepositoriesParams {
    private String query;
    private GetRepositoriesParams() {}

    public static GetRepositoriesParams create() {
        return new GetRepositoriesParams();
    }

    /** Sets query params for GET request
     ** @param {String}
     */
    public void setQuery(String q) { this.query = q; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        // shoudl query be valid
        sb.append("q=");
        sb.append(this.query);
        return sb.toString();
    }
}
