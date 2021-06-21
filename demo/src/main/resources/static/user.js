fetch('/api/user').then(
    res => {
        res.json().then(
            data => {
                console.log(data)
                let temp = "";
                temp += "<tr id=\"" + data.id + "\">";
                temp += "<td>" + data.id + "</td>";
                temp += "<td>" + data.name + "</td>";
                temp += "<td>" + data.surname + "</td>";
                temp += "<td>" + data.age + "</td>";
                temp += "<td>" + data.email + "</td>";
                let rolesStr = "";
                data.roles.forEach(r => {
                    rolesStr += r.name + " ";
                })
                temp += rolesStr + "</td>" + "</tr>";
                document.getElementById("tableUserBody").innerHTML = temp;
            }
        )
    }
)