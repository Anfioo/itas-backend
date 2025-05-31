import axios from '../../utils/axios'

export function addMessage(data) {
    return axios.post('/admin/message', data)
}

export function getMessagePage(params) {
    return axios.get('/admin/message/page', {
        params: {
            pageNum: params.pageNum || 1,
            pageSize: params.pageSize || 10,
            ...params.query
        }
    });
}

export function removeBatchMessage(ids) {
    return axios.delete('/admin/message/batch', {
        data: ids
    });
} 