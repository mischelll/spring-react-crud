import { useEffect } from 'react';
import React, { useState } from 'react';
import { getAllGroups, getGroupById, deleteGroupById } from '../services/groupService'
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';

export default function GroupList() {

    const [groups, setGroups] = useState([]);
    const [loading, setIsLoading] = useState(false);

    useEffect(() => {
        setIsLoading(true);

         getAllGroups().then(data => {
            setGroups(data);
            setIsLoading(false);
        })

    }, []);

    const groupList = groups.map(group => {
        const address = `${group.address || ''} ${group.city || ''} ${group.stateOrProvince || ''}`;
        return <tr key={group.id}>
            <td style={{ whiteSpace: 'nowrap' }}>{group.name}</td>
            <td>{address}</td>
            <td>
                <ButtonGroup>
                    <Button size="sm" color="primary" tag={Link} to={"/groups/" + group.id}>Edit</Button>
                    {/* <Button size="sm" color="danger" onClick={() => remove(group.id)}>Delete</Button> */}
                </ButtonGroup>
            </td>
        </tr>
    })

    if (loading) {
        return <p>Loading...</p>
    }

    return (
        <>
           <Container fluid>
        <div className="float-end">
          <Button color="success" tag={Link} to="/groups/new">Add Group</Button>
        </div>
        <h3>My JUG Tour</h3>
        <Table className="mt-4">
          <thead>
          <tr>
            <th width="20%">Name</th>
            <th width="20%">Location</th>
            <th>Events</th>
            <th width="10%">Actions</th>
          </tr>
          </thead>
          <tbody>
          {groupList}
          </tbody>
        </Table>
      </Container>
        </>
    )
}