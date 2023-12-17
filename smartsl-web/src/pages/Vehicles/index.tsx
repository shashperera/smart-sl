import React, { useState } from 'react'

import { Row, Col, Table, PageHeader, TablePaginationConfig, Card } from 'antd';
import useUserReducer from '../../context/UserContext/UserReducer';

type Props = {}

const cols = [
    {
        title: 'Vehicle ID',
        dataIndex: 'vehicleId',
        sorter: true,
        width: '20%',
    },
    {
        title: 'Vehicle Number',
        dataIndex: 'vehicleNumber',
        sorter: true,
        width: '20%',
    },
    {
        title: 'Vehicle Type',
        dataIndex: 'vehicleType',    
    },
    {
        title: 'Status',
        dataIndex: 'status',
        filters: [
            { text: 'Active', value: 'active' },
            { text: 'Inactive', value: 'inactive' },
        ],
    },


];

const dataSource = [
    {
      key: '1',
      vehicleId: 'V001',
      vehicleNumber: 'wp14326',
      vehicleType: 'Bus',
      status:'Active',
    },
    {
        key: '2',
        vehicleId: 'V002',
        vehicleNumber: 'wpqw1426',
        vehicleType: 'Bus',
        status:'Active',
    },
    {
        key: '3',
        vehicleId: 'V003',
        vehicleNumber: 'KW4723',
        vehicleType: 'Bus',
        status:'Active',
    },
    {
        key: '4',
        vehicleId: 'V004',
        vehicleNumber: 'PS6200',
        vehicleType: 'Bus',
        status:'Active',
    },
    {
        key: '5',
        vehicleId: 'V005',
        vehicleNumber: 'GG584',
        vehicleType: 'Bus',
        status:'Active',
    },
    {
        key: '6',
        vehicleId: 'V006',
        vehicleNumber: 'PSD1235',
        vehicleType: 'Bus',
        status:'Active',
    },
  ];
  
export default function Vehicles(props: Props): JSX.Element {
    return (
        <Card title="Map" bordered={false}>
            <Table
               columns={cols}
               dataSource={dataSource}
                //pagination={pages}
               // rowKey={record => record.login.uuid}
            />                       
         </Card>
    )
}
