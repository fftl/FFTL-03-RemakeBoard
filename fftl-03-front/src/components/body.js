import React from 'react';
import styled from 'styled-components';

const MyBody = styled.div`
    min-width: 100%;
    min-height: 600px;

    margin-top: 30px;
    margin-bottom: 30px;

    border: solid 1.5px;
`;

function Body() {
    return <MyBody className="MyBody"></MyBody>;
}

export default Body;
