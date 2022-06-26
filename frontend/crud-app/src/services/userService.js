const apiURL = 'http://localhost:8080/api/v1/user';

export const getUser = () => {
    return fetch(apiURL, { credentials: 'include' })
        .then(response => response.text());
}