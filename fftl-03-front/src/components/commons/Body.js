import React from 'react';
import styled from 'styled-components';
import PostMain from '../post/PostMain';

const MyBody = styled.div`
    min-width: 100%;
    min-height: 600px;

    margin-top: 30px;
    margin-bottom: 30px;

    border: solid 1.5px;
`;

function Body() {
    return (
        <MyBody className="MyBody">
            <PostMain />
        </MyBody>
    );
}

export default Body;
