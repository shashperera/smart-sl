
export function createUserRole(): void {

    const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            contentType: "application/json; charset=utf-8",
            body: JSON.stringify({
                                     "name" : "Admin",
                                     "code" : "Admin001",
                                     "status" : 1
                                 })
        };
        fetch('http://localhost:8090/smartsl/create-user-role', requestOptions)
            .then(response => response.json())
            .then(data => console.log(data));

}