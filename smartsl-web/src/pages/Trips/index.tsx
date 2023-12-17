import React, {useEffect, useState} from 'react'
import {Row, Col, Table, PageHeader, TablePaginationConfig} from 'antd';
import useUserReducer from "../../context/UserContext/UserReducer";

type Props = {}

export default function Trips(props: Props): JSX.Element {

    const [pages, SetPages] = useState<TablePaginationConfig>( {
        current: 1,
        pageSize: 10,
    });
    const [loading, SetLoading] = useState(false);

    const {state: UserState, methods: {getUsers}} = useUserReducer();

    useEffect(() => {
       getUsers(pages);
       console.log('testing', UserState);
    }, []);

    const cols = [
        {
            title: 'Name',
            dataIndex: 'name',
            sorter: true,
            //render: name => {`${name.first} ${name.last}`},
            width: '20%',
        },
        {
            title: 'Gender',
            dataIndex: 'gender',
            filters: [
                { text: 'Male', value: 'male' },
                { text: 'Female', value: 'female' },
            ],
            width: '20%',
        },
        {
            title: 'Email',
            dataIndex: 'email',
        },
    ];


    return (
        <>
          <Row justify="start">
              <PageHeader
                  className="site-page-header"
                  onBack={() => null}
                  title="Trips"
                  subTitle=""
              />
            <Col span={24}>
                <Table
                    columns={cols}
                    pagination={pages}
                    rowKey={record => record.login.uuid}
                    loading={loading}
                    dataSource={UserState.users.results}
                     />
            </Col>
          </Row>
        </>
    )
}
