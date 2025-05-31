import axios from '../../utils/axios'

export function addClass(data) {
    return axios.post('/admin/class', data)
}

export function getClassPage(params) {
    return axios.get('/admin/class/page', {
        params: {
            pageNum: params.pageNum || 1,
            pageSize: params.pageSize || 10,
            ...params.query
        }
    });
}

export function removeBatchClass(ids) {
    return axios.delete('/admin/class/batch', {
        data: ids
    });
} 