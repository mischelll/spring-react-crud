const apiURL = 'http://localhost:8080/api/v1'

export const getAllGroups = () => {
    let url = `${apiURL}/groups`;
    return fetch(url).then(res => res.json());
}

export const getGroupById = (id) => {
    let url = `${apiURL}/groups/${id}`;
    return fetch(url).then(res => res.json());
}

export const deleteGroupById = (id) => {
    let url = `${apiURL}/groups/${id}`;
    return fetch(url,
        {
            method: 'DELETE'
        })
        .then(res => res.json());
}
