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
            method: 'DELETE',
        });
}

export const createGroup = (body) => {
    return fetch(`${apiURL}`, {
        method: 'POST',
        body: JSON.stringify(body),
        headers: {
            'Access-Control-Allow-Origin': 'http://localhost:3000',
            'Accept': 'application/json',
            'Content-Type': 'application/json'
           
        }
    });
}

export const updateGroupById = (id, body) => {
    return fetch(`${apiURL}/${id}`, {
        method: 'PATCH',
        body: JSON.stringify(body),
        headers: {
            'Access-Control-Allow-Origin': 'http://localhost:3000',
            'Accept': 'application/json',
            'Content-Type': 'application/json'
           
        }
    });
}
