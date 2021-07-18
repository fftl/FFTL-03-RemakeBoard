import React from 'react';
import styled from 'styled-components';

const BaseBox = styled.div`
    width: 100px;
    height: 100px;
`;

const RedBox = styled(BaseBox)`
    background-color: #ff0032;
`;

const BlueBox = styled(BaseBox)`
    background-color: #00eaff;
`;

const GreenBox = styled(BaseBox)`
    background-color: green;
`;

function App() {
    return (
        <div>
            <RedBox />
            <BlueBox />
            <GreenBox />
        </div>
    );
}

export default App;
