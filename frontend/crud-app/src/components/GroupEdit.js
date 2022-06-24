import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { deleteGroupById, createGroup, updateGroup, getGroupById } from '../services/groupService';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

export default function GroupEdit() {
    const initialFormState = {
        name: '',
        address: '',
        city: '',
        stateOrProvince: '',
        country: '',
        postalCode: ''
    };

    const [group, setGroup] = useState(initialFormState);
    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
        if (id !== 'new') {
            getGroupById(id).then(data => setGroup(data));
        }
    }, [id, setGroup]);

    const handleChange = (event) => {
        const { name, value } = event.target

        setGroup({ ...group, [name]: value })
    }


    const handleSubmit = async (event) => {
        event.preventDefault();

        if (group.id) {
            updateGroup(id, group);
        } else {
            createGroup(group);
        }

        setGroup(initialFormState);
        navigate('/groups');
    }

    const title = <h2>{group.id ? 'Edit Group' : 'Add Group'}</h2>;


    return (<>
        <Container>
            {title}
            <Form onSubmit={handleSubmit}>
                <FormGroup>
                    <Label for="name">Name</Label>
                    <Input type="text" name="name" id="name" value={group.name || ''}
                        onChange={handleChange} autoComplete="name" />
                </FormGroup>
                <FormGroup>
                    <Label for="address">Address</Label>
                    <Input type="text" name="address" id="address" value={group.address || ''}
                        onChange={handleChange} autoComplete="address-level1" />
                </FormGroup>
                <FormGroup>
                    <Label for="city">City</Label>
                    <Input type="text" name="city" id="city" value={group.city || ''}
                        onChange={handleChange} autoComplete="address-level1" />
                </FormGroup>
                <div className="row">
                    <FormGroup className="col-md-4 mb-3">
                        <Label for="stateOrProvince">State/Province</Label>
                        <Input type="text" name="stateOrProvince" id="stateOrProvince" value={group.stateOrProvince || ''}
                            onChange={handleChange} autoComplete="address-level1" />
                    </FormGroup>
                    <FormGroup className="col-md-5 mb-3">
                        <Label for="country">Country</Label>
                        <Input type="text" name="country" id="country" value={group.country || ''}
                            onChange={handleChange} autoComplete="address-level1" />
                    </FormGroup>
                    <FormGroup className="col-md-3 mb-3">
                        <Label for="country">Postal Code</Label>
                        <Input type="text" name="postalCode" id="postalCode" value={group.postalCode || ''}
                            onChange={handleChange} autoComplete="address-level1" />
                    </FormGroup>
                </div>
                <FormGroup>
                    <Button color="primary" type="submit">Save</Button>{' '}
                    <Button color="secondary" tag={Link} to="/groups">Cancel</Button>
                </FormGroup>
            </Form>
        </Container>
    </>
    )
};
