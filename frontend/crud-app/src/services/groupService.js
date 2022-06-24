const apiURL = 'http://localhost:8080/api/v1/groups'

export const getAllGroups = () => {
    return fetch(apiURL).then(res => res.json());
}

export const getGroupById = (id) => {
    return fetch(`${apiURL}/${id}`).then(res => res.json());
}

export const deleteGroupById = (id) => {
    return fetch(`${apiURL}/${id}`,
        {
            method: 'DELETE'
        });
}

export const createGroup = (body) => {
    return fetch(apiURL, {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(body)
    }).then(res => res.json());
}

export const updateGroup = (id, body) => {
    return fetch(`${apiURL}/${id}`, {
        method: "PATCH",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(body)
    })
    .then(res => res.json());
}