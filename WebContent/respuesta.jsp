<html>
<head>
    <title>Password Result</title>
</head>
<body>
    <h2>Password Strength Result</h2>
    <p>
        Your password is 
        <strong>
            <% 
            Boolean isStrong = (Boolean) request.getAttribute("isStrong");
            if (isStrong != null && isStrong) { 
                out.print("strong"); 
            } else { 
                out.print("not strong enough"); 
            } 
            %>
        </strong>.
    </p>
</body>
</html>
