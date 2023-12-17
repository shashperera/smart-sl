import React from 'react'
import Header from './Header'
import { Layout, Spin } from 'antd'
import useAppContainerReducer from '../../context/AppContainer/AppContainerReducer'
import './index.scss'

type Props = {
    children: JSX.Element | JSX.Element[]
}

export default function AppContainer(props: Props): JSX.Element {
    const { state } = useAppContainerReducer()

    return (
        <Spin spinning={state.loading} size={'large'}>
            <Layout className={'app-container'}>
                <Header />
                <Layout.Content className={'content'}>{props.children}</Layout.Content>
                <Layout.Footer className={'footer'}>Smart SL (Pvt) Ltd</Layout.Footer>
            </Layout>
        </Spin>
    )
}
