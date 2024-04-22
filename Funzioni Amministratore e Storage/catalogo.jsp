<%-- File.jsp --%>

<!DOCTYPE html>
<html>


    <div class="filter-class">
        <div class="filter-container">
            
      <%
        int numRettangoli = 8;
        int numOpzioni = 4;
        String nomeDefault = "Default";

        for (int i = 0; i < numRettangoli; i++) {
            %>
            <div style="width: 200px; height: 100px; border: 1px solid black;">
                <%-- Nome e opzioni del rettangolo --%>
                <p>Nome: <%= nomeDefault %></p>
                <p>Opzioni:</p>
                <ul>
                    <%-- Genera le opzioni --%>
                    <% for (int j = 0; j < numOpzioni; j++) { %>
                        <li><%= "Opzione " + (j + 1) %></li>
                    <% } %>
                </ul>
            </div>
            <br/>
            <%
        }
    %>
        </div>
    </div>

    <div class="grid-container">
        <%-- Genera i rettangoli --%>
        <% for (int i = 0; i < 9; i++) { %>
            <div class="rectangle">
                <div class="text">
                    <p>Nome Prodotto <%= (i + 1) %></p>
                    <p>Prezzo: $<%= (i + 1) * 10 %></p>
                </div>
                <div></div>
            </div>
        <% } %>
    </div>
    



</html>

