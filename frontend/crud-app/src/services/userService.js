const apiURL = 'http://localhost:8080/api/v1';

export const getUser = () => {
    return fetch(`${apiURL}/user`, {
        credentials: 'include',
        headers: {
            'Access-Control-Allow-Origin': 'http://localhost:3000'
        }
    })
        .then(response => response.text());
}

export const sendLogoutReq = (httpHeaders) => {
    return fetch(`${apiURL}/logout`, httpHeaders)
        .then(res => res.json())
        .then(response => {
            window.location.href = `${response.logoutUrl}?id_token_hint=${response.idToken}`
                + `&post_logout_redirect_uri=${window.location.origin}`;
        });
}