import axios from '../../utils/axios'

export function addResource(data) {
    return axios.post('/admin/resource', data)
}

export function getResourcePage(params) {
    return axios.get('/admin/resource/page', {
        params: {
            pageNum: params.pageNum || 1,
            pageSize: params.pageSize || 10,
            ...params.query
        }
    });
}

export function removeBatchResource(ids) {
    return axios.delete('/admin/resource/batch', {
        data: ids
    });
} 